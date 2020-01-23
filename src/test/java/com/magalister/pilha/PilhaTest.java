package com.magalister.pilha;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.magalister.pilha.exceptions.EstouroDePilhaException;
import com.magalister.pilha.exceptions.PilhaVaziaException;
import com.magalister.pilha.impl.PilhaImpl;

/**
 * Testes unitários para a classe Pilha.
 * 
 * @author Carlos Feitosa (carlos.feitosa.nt@#gmail.com)
 * @since 2020-01-22
 *
 */
class PilhaTest {

	private Pilha<Integer> pilhaInteiros;

	private static final int TAMANHO_REDUZIDO = 2;

	private static final String ASSERT_MSG_TAMANHO_FILA = "Tamanho da pilha diferente da esperada";
	private static final String ASSERT_MSG_ELEMENTO = "Elemento diferente do esperado";
	private static final String ASSERT_MSG_EXCECAO = "Exceção diferente da esperada";

	/**
	 * Inicializa a pilha.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		pilhaInteiros = new PilhaImpl<Integer>();
	}

	/**
	 * Testa se a pilha consegue adicionar um item (push), no topo da estrutura.
	 * Pode estourar uma exceção por estouro de pilha.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 */
	@Test
	public void consegueAdicionarItem() throws EstouroDePilhaException {
		int numero = 7777;
		int tamanhoPilha = pilhaInteiros.size();

		pilhaInteiros.push(numero);

		assertTrue(pilhaInteiros.size() == (tamanhoPilha + 1), ASSERT_MSG_TAMANHO_FILA);
	}

	/**
	 * Testa se a pilha consegue recuperar e remover (pop) um item, no topo da
	 * estrutura. Pode estourar uma exceção por não haver elementos.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 * @throws PilhaVaziaException     se a pilha estiver vazia na tentativa de
	 *                                 recupearar um item
	 */
	@Test
	public void conseguePegarItem() throws EstouroDePilhaException, PilhaVaziaException {
		int numero = 7777;

		pilhaInteiros.push(numero);

		int tamanhoPilha = pilhaInteiros.size();

		int numeroPop = pilhaInteiros.pop();

		assertEquals(numero, numeroPop, ASSERT_MSG_ELEMENTO);
		assertEquals(pilhaInteiros.size(), tamanhoPilha - 1, ASSERT_MSG_TAMANHO_FILA);
	}

	/**
	 * Testa se a pilha consegue recuperar sem remover (peek) um item, no topo da
	 * estrutura. Pode estourar exceção por não haver elementos.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 * @throws PilhaVaziaException     se a pilha estiver vazia na tentativa de
	 *                                 recupearar um item
	 */
	@Test
	public void conseguePegarItemSemRemover() throws EstouroDePilhaException, PilhaVaziaException {
		int numero1 = 7777;
		int numero2 = 6666;

		pilhaInteiros.push(numero1);
		pilhaInteiros.push(numero2);

		int tamanhoPilha = pilhaInteiros.size();

		assertEquals(numero2, pilhaInteiros.peek(), ASSERT_MSG_ELEMENTO);
		assertTrue(pilhaInteiros.size() == tamanhoPilha, ASSERT_MSG_TAMANHO_FILA);
		assertEquals(numero2, pilhaInteiros.pop(), ASSERT_MSG_ELEMENTO);
		assertEquals(numero1, pilhaInteiros.pop(), ASSERT_MSG_ELEMENTO);
	}

	/**
	 * Testa se a pilha consegue achar um elemento.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 * @throws PilhaVaziaException     se a pilha estiver vazia na tentativa de
	 *                                 recupearar um item
	 */
	@Test
	public void consegueAcharItem() throws EstouroDePilhaException, PilhaVaziaException {
		int numero = 7777;

		pilhaInteiros.push(1234);
		pilhaInteiros.push(4534);
		pilhaInteiros.push(3485);
		pilhaInteiros.push(numero);
		pilhaInteiros.push(77344);
		pilhaInteiros.push(683749);

		assertTrue(pilhaInteiros.contains(numero), ASSERT_MSG_ELEMENTO);

	}

	/**
	 * Testa se a pilha consegue não achar um elemento.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 * @throws PilhaVaziaException     se a pilha estiver vazia na tentativa de
	 *                                 recupearar um item
	 */
	@Test
	public void consegueNaoAcharItem() throws EstouroDePilhaException, PilhaVaziaException {
		int numero = 7777;

		pilhaInteiros.push(1234);
		pilhaInteiros.push(4534);
		pilhaInteiros.push(3485);
		pilhaInteiros.push(77344);
		pilhaInteiros.push(683749);

		assertFalse(pilhaInteiros.contains(numero), ASSERT_MSG_ELEMENTO);

	}

	/**
	 * Testa se a pilha consegue saber se está vazia.
	 */
	@Test
	public void consegueSaberSeEstaVazio() {
		assertTrue(pilhaInteiros.isEmpty(), ASSERT_MSG_TAMANHO_FILA);
	}

	/**
	 * Testa se a pilha consegue saber se não está vazia.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 */
	@Test
	public void consegueSaberSeNaoEstaVazio() throws EstouroDePilhaException {
		int numero = 7777;

		pilhaInteiros.push(numero);

		assertTrue(!pilhaInteiros.isEmpty(), ASSERT_MSG_TAMANHO_FILA);
	}

	/**
	 * Testa se a pilha consegue saber se está cheia.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 */
	@Test
	public void consegueSaberSeEstaCheio() throws EstouroDePilhaException {
		pilhaInteiros = new PilhaImpl<Integer>(TAMANHO_REDUZIDO);

		int numero = 7777;

		pilhaInteiros.push(numero);
		pilhaInteiros.push(numero);

		assertTrue(pilhaInteiros.isFull(), ASSERT_MSG_TAMANHO_FILA);
	}

	/**
	 * Testa se a pilha consegue saber se não está cheia.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 */
	@Test
	public void consegueSaberSeNaoEstaCheio() throws EstouroDePilhaException {
		pilhaInteiros = new PilhaImpl<Integer>(TAMANHO_REDUZIDO);

		int numero = 7777;

		pilhaInteiros.push(numero);

		assertTrue(!pilhaInteiros.isFull(), ASSERT_MSG_TAMANHO_FILA);
	}

	/**
	 * Testa se a pilha consegue determinar seu tamanho.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 */
	@Test
	public void consegueDeterminarSeuTamanho() throws EstouroDePilhaException {
		int numero = 7777;
		int quantidade = 9;

		for (int i = 0; i < quantidade; i++) {
			pilhaInteiros.push(numero);
		}

		assertEquals(quantidade, pilhaInteiros.size(), ASSERT_MSG_TAMANHO_FILA);
	}

	/**
	 * Testa se a pilha consegue se limpar.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 */
	@Test
	public void consegueLimpar() throws EstouroDePilhaException {
		int numero = 7777;

		pilhaInteiros.push(numero);

		pilhaInteiros.clear();

		assertEquals(0, pilhaInteiros.size(), ASSERT_MSG_TAMANHO_FILA);
	}

	/**
	 * Testa se a pilha consegue estourar.
	 */
	@Test
	public void consegueEstourar() {
		int numero = 7777;
		int quantidade = pilhaInteiros.tamanhoPilha() + 1;

		assertThrows(EstouroDePilhaException.class, () -> {
			for (int i = 0; i < quantidade; i++) {
				pilhaInteiros.push(numero);
			}
		}, ASSERT_MSG_EXCECAO);
	}

	/**
	 * Testa se a pilha estoura exceção se pop|peek com a fila vazia.
	 */
	@Test
	public void consegueEstourarFilaVazia() {
		assertThrows(PilhaVaziaException.class, () -> {
			pilhaInteiros.pop();
		}, ASSERT_MSG_EXCECAO);
	}

	/**
	 * Testa se a pilha está armazenando os itens na ordem correta.
	 * 
	 * @throws EstouroDePilhaException se estourar o tamanho da pilha
	 * @throws PilhaVaziaException     se a pilha estiver vazia na tentativa de
	 *                                 recupearar um item
	 */
	@Test
	public void consegueEmpilhar() throws EstouroDePilhaException, PilhaVaziaException {
		int[] itens = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] itensReverso = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		for (int i = 0; i < itens.length; i++) {
			pilhaInteiros.push(itens[i]);
		}

		for (int i = 0; i < itensReverso.length; i++) {
			int numeroExperado = itensReverso[i];
			int numeroPilha = pilhaInteiros.pop();

			assertEquals(numeroExperado, numeroPilha, ASSERT_MSG_ELEMENTO);
		}
	}

}
