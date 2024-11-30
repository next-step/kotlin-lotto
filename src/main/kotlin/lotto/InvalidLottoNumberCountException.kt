package lotto

class InvalidLottoNumberCountException(numbers: Set<Int>) : RuntimeException(
    "로또 번호는 ${Lotto.NUMBER_COUNT}개가 입력되어야 합니다. 현재 입력 = $numbers",
)
