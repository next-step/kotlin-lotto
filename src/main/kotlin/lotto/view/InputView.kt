package lotto.view

object InputView {

    fun printInputLottoBuyMoney(): String {
        println("구입 금액을 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }

    fun printInputLottoNumberByLastWeek(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }

    fun printInputBonusLottoNumber(): String {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }
}
