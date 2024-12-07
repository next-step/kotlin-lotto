package lotto.domain

class InvalidLottoNumberException(number: Int) : RuntimeException(
    "로또 번호는 ${LottoNumber.MIN_LOTTO_NUMBER}~${LottoNumber.MAX_LOTTO_NUMBER} 까지의 값이어야 합니다. 현재 입력 = $number",
)
