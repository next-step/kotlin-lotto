package lotto.domain

class InvalidAmountException(amount: Long) : RuntimeException("입력 금액은 1천원 단위여야 합니다. 현재 입력 = $amount")
