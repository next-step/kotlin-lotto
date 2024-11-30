package lotto

class InvalidLottoNumberException(numbers: Set<Int>) : RuntimeException(
    "로또 번호는 ${Lotto.MIN_LOTTO_NUMBER}~${Lotto.MAX_LOTTO_NUMBER} 까지의 값이어야 합니다. 현재 입력 = $numbers",
)
