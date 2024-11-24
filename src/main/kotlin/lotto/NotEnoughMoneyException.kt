package lotto

class NotEnoughMoneyException(money: Int) : RuntimeException("입력 금액은 1천원 단위여야 합니다. 현재 입력 = $money")
