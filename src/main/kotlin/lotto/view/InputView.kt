package lotto.view

object InputView {

    fun inputLottoBuyMoney(): String {
        println("구입 금액을 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }

    fun inputLottoNumberByLastWeek(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }

    fun inputBonusLottoNumber(): String {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }

    fun inputBuyManualLottoCount(): String {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }

    fun inputManualLottoNumbersByCount(count: Int): List<String> {
        val lottoNumbers = mutableListOf<String>()
        println("수동으로 구매할 번호를 입력해주세요.")
        repeat(count) {
            val input = readlnOrNull() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
            lottoNumbers.add(input)
        }
        return lottoNumbers.toList()
    }
}
