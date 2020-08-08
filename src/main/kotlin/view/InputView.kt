package view

import model.Money

class InputView {
    fun getMoney(input: () -> String?): Money {
        println("구매금액을 입력해 주세요.")
        return Money(input())
    }
}
