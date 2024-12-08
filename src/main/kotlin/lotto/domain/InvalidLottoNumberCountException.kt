package lotto.domain

class InvalidLottoNumberCountException(numbers: Set<LottoNumber>) : RuntimeException(
    "로또 번호는 ${LottoNumbers.NUMBER_COUNT}개가 입력되어야 합니다. 현재 입력 = $numbers",
)
