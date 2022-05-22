package lotto.view

class InputView {

    fun enterMoney(): String {
        println("구입금액을 입력해 주세요.")

        return readln()
    }

    fun enterWonLotto(): List<String> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readln().split(", ")
    }
}
