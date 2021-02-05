package com.nextstep.lotto.view

object LottoInputView {
    fun inputPrice(): Int {
        println("구입금액을 입력해 주세요.")
        val price = readLine()
        require(!price.isNullOrBlank()) { throw IllegalArgumentException("문자열에 null이나 빈 값이 들어가서는 안됩니다.") }

        return price.toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLottoNumbers = readLine()
        require(!winningLottoNumbers.isNullOrBlank()) { throw IllegalArgumentException("문자열에 null이나 빈 값이 들어가서는 안됩니다.") }

        return winningLottoNumbers.split(",").map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()
        require(!bonusNumber.isNullOrBlank()) { throw IllegalArgumentException("문자열에 null이나 빈 값이 들어가서는 안됩니다.") }

        return bonusNumber.toInt()
    }
}
