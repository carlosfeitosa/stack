package com.magalister.pilha.impl;

import com.magalister.pilha.Pilha;
import com.magalister.pilha.exceptions.EstouroDePilhaException;
import com.magalister.pilha.exceptions.PilhaVaziaException;

/**
 * Implementação da pilha.
 * 
 * @author Carlos Feitosa (carlos.feitosa.nt@gmail.com)
 * @since 2020-01-22.
 *
 */
public class PilhaImpl implements Pilha {

	private int[] pilha;
	private int index;

	@SuppressWarnings("unused")
	private PilhaImpl() {

	}

	public PilhaImpl(int tamanho) {
		pilha = new int[tamanho];

		clear();
	}

	/**
	 * Retorna o tamanho da pilha.
	 * 
	 * @return tamanho da pilha.
	 */
	private int tamanhoPilha() {
		return pilha.length;
	}

	@Override
	public void push(int numero) throws EstouroDePilhaException {
		if (isFull()) {
			throw new EstouroDePilhaException();
		}

		pilha[++index] = numero;
	}

	@Override
	public int pop() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}

		return pilha[index--];
	}

	@Override
	public int peek() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}

		return pilha[index--];
	}

	@Override
	public int size() {
		return index + 1;
	}

	@Override
	public void clear() {
		index = -1;
	}

	@Override
	public boolean isEmpty() {
		return (-1 == index);
	}

	@Override
	public boolean isFull() {
		return !(index + 1 < tamanhoPilha());
	}

}
