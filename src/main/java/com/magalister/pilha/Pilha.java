package com.magalister.pilha;

import com.magalister.pilha.exceptions.EstouroDePilhaException;
import com.magalister.pilha.exceptions.PilhaVaziaException;

/**
 * Interface de pilha.
 * 
 * @author Carlos Feitosa (carlos.feitosa.nt@gmail.com)
 * @since 2020-02-22
 *
 */
public interface Pilha {

	/**
	 * Adiciona item no topo da pilha.
	 * 
	 * @param numero número que deseja armazenar.
	 */
	public void push(int numero) throws EstouroDePilhaException;

	/**
	 * Recupera e remove item no topo da pilha.
	 * 
	 * @return elemento do topo da pilha.
	 */
	public int pop() throws PilhaVaziaException;

	/**
	 * Recupera item no topo da pilha.
	 * 
	 * @return elemento do topo da pilha.
	 */
	public int peek() throws PilhaVaziaException;

	/**
	 * Retorna o tamanho da pilha.
	 * 
	 * @return tamanho da pilha.
	 */
	public int size();

	/**
	 * Limpa a pilha.
	 */
	public void clear();

	/**
	 * Retorna se a pilha esta vazia.
	 * 
	 * @return verdadeiro se vazia.
	 */
	public boolean isEmpty();

	/**
	 * Retorna se a pilha esta cheia.
	 * 
	 * @return verdadeiro se cheia.
	 */
	public boolean isFull();
}
