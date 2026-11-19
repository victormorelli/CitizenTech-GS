# CitizenTech Acessível

## Integrantes
| Nome completo | RM |
|---|---|
| Victor Morelli Garrido Giardulli | RM_DO_VICTOR |

## Tema da Global Solution
**CitizenTech**: tecnologias criadas a partir das necessidades reais das pessoas.
O app apresenta um catálogo de soluções assistivas (ODS 3, 4, 9, 10, 11 e 13), com foco em
controle de computador sem toque para pessoas com mobilidade reduzida (visão computacional).

## Descrição da solução
Aplicativo Android (Kotlin + Jetpack Compose + Material Design 3) que reúne soluções
tecnológicas de acessibilidade, mobilidade, saúde, educação e trabalho, permitindo explorar
por categoria e ver os destaques.

## Principais funcionalidades
- Lista vertical (LazyColumn) com 10 soluções em Cards (ícone, título, descrição, tecnologia, público e ODS).
- Lista horizontal de categorias (LazyRow) com filtro, incluindo "Todas", com destaque visual da categoria selecionada.
- Lista horizontal de destaques (LazyRow) obtida dos mesmos dados (atributo `destaque`).
- Filtragem feita no repositório; estado da categoria com `remember` e `mutableStateOf`.

## Fluxo de telas
Tela única (`HomeScreen`): Destaques → Categorias → Lista filtrada.
Ao tocar em uma categoria, a lista principal é recomposta automaticamente.

## Prints das telas

![Tela inicial](<img width="1080" height="2340" alt="Screenshot_20261119_130222" src="https://github.com/user-attachments/assets/8a959005-5e90-4273-bcec-854909001226" />
)
![Lista filtrada-Educação](<img width="1080" height="2340" alt="Screenshot_20261119_130239" src="https://github.com/user-attachments/assets/a7ef93d1-9c26-4310-aa88-292c7f06a97c" />
)

## Fonte dos dados
Repositório em memória (`InMemorySolucaoRepository`), sem API ou banco de dados.

## Arquitetura e packages
```
br.com.fiap.victorcitizentech
├── MainActivity.kt
├── model/             Categoria (enum class), SolucaoAssistiva (data class)
├── domain/repository  SolucaoRepository (interface)
├── data/memory/       InMemorySolucaoRepository (dados em memória)
└── ui/
    ├── components/    SolucaoCard, CategoriaSelector, DestaqueCard
    ├── screen/        HomeScreen (Scaffold, TopAppBar, estado)
    └── theme/         Color, Theme, Type
```
