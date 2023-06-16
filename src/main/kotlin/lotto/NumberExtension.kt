package lotto

import java.math.BigDecimal
import java.math.RoundingMode

fun BigDecimal.scaleDown() = this.setScale(0, RoundingMode.DOWN)
