const API_URL = 'http://localhost:8080/operadoras';
let operadoras = [];

function showError(message) {
    const errorDiv = document.getElementById('error');
    errorDiv.textContent = message;
    errorDiv.style.display = 'block';
    setTimeout(() => errorDiv.style.display = 'none', 5000);
}

async function buscarOperadoras() {
    const searchInput = document.getElementById('search');
    const searchValue = searchInput.value.trim().toLowerCase();
    const loadingDiv = document.getElementById('loading');
    const tableBody = document.getElementById('operadoras-table');

    loadingDiv.style.display = 'block';
    tableBody.innerHTML = '';

    try {
        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error(`Erro HTTP: ${response.status}`);
        }

        operadoras = await response.json();

        const filteredOperadoras = searchValue
            ? operadoras.filter(operadora =>
                (operadora.razaoSocial && operadora.razaoSocial.toLowerCase().includes(searchValue)) ||
                (operadora.cnpj && operadora.cnpj.toLowerCase().includes(searchValue)) ||
                (operadora.registroANS && operadora.registroANS.toLowerCase().includes(searchValue))
              )
            : operadoras;

        exibirOperadoras(filteredOperadoras);
    } catch (error) {
        console.error('Erro ao buscar operadoras:', error);
        showError('Erro ao carregar dados. Tente novamente mais tarde.');
    } finally {
        loadingDiv.style.display = 'none';
    }
}

function formatarCNPJ(cnpj) {
    if (!cnpj) return '-';
    return cnpj.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, '$1.$2.$3/$4-$5');
}


function exibirOperadoras(operadoras) {
    const tableBody = document.getElementById('operadoras-table');

    if (operadoras.length === 0) {
        tableBody.innerHTML = `<tr><td colspan="6" style="text-align: center;">Nenhuma operadora encontrada</td></tr>`;
        return;
    }

    tableBody.innerHTML = operadoras.map(operadora => `
        <tr>
            <td>${operadora.id || '-'}</td>
            <td>${operadora.registroANS || '-'}</td>
            <td>${formatarCNPJ(operadora.cnpj)}</td>
            <td>${operadora.razaoSocial || '-'}</td>
            <td>${operadora.nomeFantasia || '-'}</td>
        </tr>
    `).join('');
}

// Event listeners
document.getElementById('search').addEventListener('keyup', (event) => {
    if (event.key === 'Enter') {
        buscarOperadoras();
    }
});

// Carrega as operadoras ao iniciar
document.addEventListener('DOMContentLoaded', buscarOperadoras);