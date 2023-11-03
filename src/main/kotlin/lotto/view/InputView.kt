package lotto.view

import lotto.domain.LottoStore

object InputView {

    fun inputPrice(): Int {
        println("구입금액을 입력해 주세요.")
        val price = readln()
        return try {
            require(price.isNotBlank())
            price.toInt()
        } catch (e: NumberFormatException) {
            println(NUMBER_ERROR_MESSAGE)
            inputPrice()
        } catch (e: IllegalArgumentException) {
            println(BLANK_ERROR_MESSAGE)
            inputPrice()
        }
    }

    fun inputWinningLotto(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLotto = readln()
        return parseLottoNumber(winningLotto)
    }

    private fun parseLottoNumber(input: String): List<Int> {
        return try {
            require(input.isNotBlank()) { println(BLANK_ERROR_MESSAGE) }
            input.split(DELIMITER).map { it.trim().toInt() }
                .validateWinningLotto()
        } catch (e: NumberFormatException) {
            println(NUMBER_ERROR_MESSAGE)
            inputWinningLotto()
        } catch (e: IllegalArgumentException) {
            inputWinningLotto()
        }
    }

    private fun List<Int>.validateWinningLotto(): List<Int> {
        require(this.size == LottoStore.LOTTO_NUMBER_SIZE) {
            println("당첨 번호는 ${LottoStore.LOTTO_NUMBER_SIZE}자리만 입력 가능합니다.")
        }

        require(this.all { it in LottoStore.LOTTO_NUMBER_MIN..LottoStore.LOTTO_NUMBER_MAX }) {
            println(
                "당첨 번호는 ${LottoStore.LOTTO_NUMBER_MIN}~" +
                    "${LottoStore.LOTTO_NUMBER_MAX}까지의 숫자만 입력 가능합니다."
            )
        }

        require(this.size == this.toSet().size) {
            println("당첨 번호는 중복되지 않습니다.")
        }

        return this
    }

    private const val DELIMITER = ","
    private const val BLANK_ERROR_MESSAGE = "입력값이 없습니다."
    private const val NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요."
}
