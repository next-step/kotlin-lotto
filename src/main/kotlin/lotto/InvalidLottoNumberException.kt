package lotto

class InvalidLottoNumberException(numbers: List<Int>) : RuntimeException("로또 번호는 ${LottoPolicy.MIN_LOTTO_NUMBER}~${LottoPolicy.MAX_LOTTO_NUMBER} 까지의 값이어야 합니다. 현재 입력 = $numbers")
