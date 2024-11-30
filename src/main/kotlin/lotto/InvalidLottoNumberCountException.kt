package lotto

class InvalidLottoNumberCountException(numbers: List<Int>) : RuntimeException(
    "로또 번호는 ${Lotto.NUMBER_COUNT}개만 입력되어야 합니다. 현재 입력 = $numbers",
)
