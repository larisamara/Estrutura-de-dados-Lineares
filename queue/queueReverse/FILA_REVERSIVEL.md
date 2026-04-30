# Fila Circular com Reversão em O(1)

Este documento descreve a implementação da `QueueInverse`, uma fila que suporta a operação de reversão instantânea utilizando um array circular.

## Arquitetura da Solução

A fila foi projetada para garantir que as operações de inserção (`enqueue`), remoção (`dequeue`) e reversão (`reverse`) ocorram em tempo constante.

### 1. Reversão em O(1)
Diferente de uma fila tradicional onde a reversão exigiria percorrer todos os elementos (O(n)), esta implementação utiliza uma flag booleana `invertida`.
- Quando `invertida` é `false`: a fila opera normalmente (FIFO).
- Quando `invertida` é `true`: a lógica de inserção e remoção é alternada. O que era o "fim" passa a se comportar como "início" e vice-versa.

### 2. Array Circular
Para otimizar o uso de memória e evitar o deslocamento de elementos, utilizamos índices `inicio` e `fim` que "dão a volta" no array usando o operador de módulo (`%`).

## Guia Detalhado dos Métodos (Para Iniciantes)

Imagine a fila como uma fileira de cadeiras em um círculo.

### `isEmpty()` - A fila está vazia?
Apenas olha se o contador de pessoas na fila é zero.
- **Exemplo:** Se não tem ninguém na fila, retorna `true`. Se tem pelo menos uma pessoa, retorna `false`.

### `enqueue(Object o)` - Entrar na fila
Adiciona um novo elemento. Se a fila estiver cheia, ela "aumenta de tamanho" automaticamente.
- **Modo Normal:** A pessoa entra no final da fila (como em um banco).
- **Modo Invertido:** A pessoa "fura a fila" e entra lá na frente, porque agora a frente virou o fundo!
- **Exemplo:** Fila `[A, B]`. `enqueue(C)` no modo normal vira `[A, B, C]`. No modo invertido, `C` entraria antes do `A`.

### `dequeue()` - Sair da fila
Remove quem está no início e entrega para você.
- **Modo Normal:** Remove quem chegou primeiro.
- **Modo Invertido:** Remove quem estava lá no final, pois a fila virou!
- **Exemplo:** Fila `[A, B, C]`. `dequeue()` no modo normal tira o `A`. Se estivesse invertida (`[C, B, A]`), tiraria o `C`.

### `reverse()` - O "Giro" Mágico
Este é o diferencial. Ele não move ninguém de lugar. Ele apenas vira uma chave que diz: "A partir de agora, o fundo é o início".
- **Por que é O(1)?** Porque trocar o valor de uma "chave" (booleano) é instantâneo, não importa se a fila tem 10 ou 1 milhão de itens.

### `front()` e `back()` - Espiar
- `front()`: Olha quem é o próximo a sair sem tirar ele da fila.
- `back()`: Olha quem é o último da fila.

### `getLogico(int i)` - O Tradutor
Este método é o cérebro da fila. Ele traduz a posição que você pede (ex: "me dê o 2º da fila") para a posição real na memória do computador.
- Se a fila está invertida, ele faz o cálculo matemático para começar a contar de trás para frente.

### `redimensionar(int novaCapacidade)` - Ajuste de Espaço
Como uma sanfona, a fila cresce quando enche e encolhe quando fica muito vazia (menos de 1/3 usada). Isso evita que o computador desperdice memória.

## Complexidade das Operações

| Operação | Complexidade | Observação |
| :--- | :--- | :--- |
| `enqueue` | O(1) | Rápido (quase sempre instantâneo) |
| `dequeue` | O(1) | Rápido |
| `reverse` | O(1) | Instantâneo (o grande truque!) |
| `isEmpty` | O(1) | Instantâneo |
| `print`   | O(n) | Demora conforme o tamanho da fila |
