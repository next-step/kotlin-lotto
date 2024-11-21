package lotto

import lotto.number.Numbers

class Lotto(
    val numbers: Numbers =
        Numbers(
            (1..45)
                .toList()
                .shuffled()
                .take(6)
                .sorted(),
        ),
)
