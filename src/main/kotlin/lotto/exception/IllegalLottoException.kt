package lotto.exception

class IllegalLottoException(message: String = "로또는 6개의 서로 다른 LottoNumber 로 구성되어야 합니다.") : RuntimeException(message)
