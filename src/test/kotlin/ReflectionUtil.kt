class ReflectionUtil {
    companion object {

        fun setField(obj: Any, fieldName: String, newData: Any) {
            val field = obj.javaClass.getDeclaredField(fieldName)
            field.isAccessible = true
            field.set(obj, newData)
        }

        fun getField(obj: Any, fieldName: String): Any {
            val field = obj.javaClass.getDeclaredField(fieldName)
            field.isAccessible = true
            return field.get(obj)
        }
    }
}
