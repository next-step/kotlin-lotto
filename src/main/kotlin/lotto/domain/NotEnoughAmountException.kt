package lotto.domain

class NotEnoughAmountException(count: Int) : RuntimeException("입력 금액보다 더 많은 개수의 로또를 구매할 수 없습니다. 현재 입력 개수 = $count")
