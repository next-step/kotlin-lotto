package lotto.exception

class IllegalLottoNumberException(message: String = "로또의 번호는 1과 45 사이의 숫자여야 합니다.") : RuntimeException(message)
