# Estruturas de Dados Lineares - TADs Posicionais e por Índice

Este projeto contém a implementação de três Tipos Abstratos de Dados (TADs) fundamentais, utilizando as linguagens e conceitos clássicos de ensino de Estrutura de Dados no Brasil.

## 1. TAD Vetor (`IVetor`)
Focado no acesso através de um **índice** (ou rank).
- **Implementação**: `VetorArranjo` (Array dinâmico).
- **Conceitos Chave**: Deslocamento de elementos para inserção/remoção e redimensionamento automático.

## 2. TAD Lista Posicional (`ILista`)
Focado no acesso através de **Posições** (nós), permitindo inserções eficientes em qualquer lugar da lista.
- **Implementação**: `ListaEncadeada` (Lista Duplamente Encadeada).
- **Conceitos Chave**: Uso de **Nós Sentinelas** (`inicio` e `fim`) para eliminar casos especiais (como remover o último elemento) e facilitar a implementação.

## 3. TAD Sequência (`ISequencia`)
A estrutura mais versátil, combinando as funcionalidades de Vetor e Lista.
- **Implementação**: `SequenciaLista`.
- **Conceitos Chave**: Métodos de ponte (`noNoIndice` e `indiceDe`) que permitem navegar na lista usando números ou referências de memória.

---

### Tabela de Complexidade

| Operação | Vetor (Arranjo) | Lista (Encadeada) | Sequência (Lista) |
| :--- | :---: | :---: | :---: |
| Acesso por Índice | $O(1)$ | N/A | $O(n)$ |
| Inserção/Remoção (Extremos) | $O(n)$ | $O(1)$ | $O(1)$ |
| Inserção/Remoção (Meio) | $O(n)$ | $O(1)$* | $O(n)$** |

*\*Assumindo que você já tem o nó.*
*\*\*Devido à necessidade de encontrar o nó pelo índice antes da operação.*

---

### Como Executar os Testes

Para compilar e rodar o projeto completo:

```bash
# Compila todos os pacotes e a classe principal
javac list/*.java vector/*.java sequence/*.java Main.java

# Executa o programa de teste
java Main
```

---
**Nota Didática**: O código foi escrito priorizando a clareza e a facilidade de explicação para um professor, utilizando nomes de métodos e variáveis em português e seguindo a lógica de sentinelas e deslocamentos manuais de memória (no caso do arranjo).
