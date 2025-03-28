Comecei a desenvolver pela parte de conversão de arquivo, e usei 3 classe, Ler arquivo: nessa classe tem o código onde o Spring vê se o arquivo realmente está no seu diretório, se estiver aparece no terminal do IntelliJ “Arquivo encontrado: Anexo_I.pdf”.

ExtrairTextoPDF: Nesta classe, o código tem a funcionalidade de abrir o arquivo PDF e extrair seu conteúdo. Utilizando a biblioteca Apache PDFBox, o código lê cada página do PDF, extrai o texto e o exibe no terminal.

SalvarCSV: Esta classe é responsável por pegar os dados extraídos do PDF, processá-los e salvar em um arquivo CSV. Algumas variáveis são definidas para tornar o código mais fácil de entender, como o diretório base, nome do arquivo PDF e o arquivo CSV de saída. Após extrair os dados, a classe cria o arquivo CSV e compacta o CSV em um arquivo ZIP.

Agora na parte do banco de dados eu utilizei o MySQL, criando as tabelas pelo IntelliJ no diretório db.migration, onde foi criado 8 tabelas, representando cada mês , foram 4 tabelas do ano de 2023 e 4 do ano de 2024.

Além disso, salvei os dados de planilhas CSV nessas tabelas, permitindo uma integração simples entre os dados extraídos das planilhas, já as query estão no MySQL. A API foi desenvolvida utilizando Spring Boot e conta com 4 classes principais: OperadorasAtivas: Contém os dados das operadoras.

ListarOperadora: Exibe os dados que serão enviados ao front-end para visualização.

OperadorasRepository: Responsável pela manipulação dos dados no banco de dados.

OperadorasController: Mapeia as rotas e métodos da API, permitindo listar as operadoras.

Essa estrutura permite integrar o front-end com o banco de dados e exibir as informações de forma eficiente.

O front-end foi desenvolvido utilizando as tecnologias HTML, CSS e JavaScript para criar uma interface de usuário interativa e visualmente agradável.
