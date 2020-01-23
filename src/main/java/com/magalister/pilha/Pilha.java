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
public interface Pilha<T> {

	/**
	 * Retorna o tamanho da pilha.
	 * 
	 * @return tamanho da pilha.
	 */
	public int tamanhoPilha();

	/**
	 * Adiciona item no topo da pilha.
	 * 
	 * @param valor número que deseja armazenar.
	 * 
	 * @exception EstouroDePilhaException se estourar o tamanho da pilha
	 */
	public void push(T valor) throws EstouroDePilhaException;

	/**
	 * Recupera e remove item no topo da pilha.
	 * 
	 * @return elemento do topo da pilha.
	 * 
	 * @exception PilhaVaziaException se a pilha estiver vazia na tentativa de
	 *                                recupearar um item
	 */
	public T pop() throws PilhaVaziaException;

	/**
	 * Recupera item no topo da pilha.
	 * 
	 * @return elemento do topo da pilha.
	 * 
	 * @exception PilhaVaziaException se a pilha estiver vazia na tentativa de
	 *                                recupearar um item
	 */
	public T peek() throws PilhaVaziaException;

	/**
	 * Localiza elemento dentro da pilha.
	 * 
	 * @param valor valor que deseja localizar
	 * 
	 * @return verdadeiro se encontrado
	 * 
	 * @throws PilhaVaziaException
	 */
	public boolean contains(T valor) throws PilhaVaziaException;

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
