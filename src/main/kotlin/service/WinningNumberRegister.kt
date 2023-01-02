package service

import domain.LottoInput
import domain.WinningLotto

class WinningNumberRegister(
    private val randomNumberGenerator: RandomNumberGenerator
) {
    fun register(input : LottoInput): WinningLotto{
        return WinningLotto(numbers = input.winningLotto!!)
    }
}