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
public class PilhaImpl<T> implements Pilha<T> {

	private static final int TAMANHO_DEFAULT = 10;

	private T[] armazenamento;
	private int index;

	@SuppressWarnings("unchecked")
	public PilhaImpl() {
		armazenamento = (T[]) new Object[TAMANHO_DEFAULT];

		clear();
	}

	@SuppressWarnings("unchecked")
	public PilhaImpl(int tamanho) {
		armazenamento = (T[]) new Object[tamanho];

		clear();
	}

	@Override
	public int tamanhoPilha() {
		return armazenamento.length;
	}

	@Override
	public void push(T valor) throws EstouroDePilhaException {
		if (isFull()) {
			throw new EstouroDePilhaException();
		}

		armazenamento[++index] = valor;
	}

	@Override
	public T pop() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}

		T value = armazenamento[index--];

		armazenamento[index + 1] = null;

		return value;
	}

	@Override
	public T peek() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}

		return armazenamento[index];
	}

	@Override
	public boolean contains(T valor) throws PilhaVaziaException {
		for (int i = 0; i < index; i++) {
			if (armazenamento[i].equals(valor)) {
				return true;
			}
		}

		return false;
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
