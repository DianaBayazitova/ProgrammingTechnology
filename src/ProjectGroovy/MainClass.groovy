package ProjectGroovy

class MainClass {
    static void main(String[] args) {
        FirstClass firstClass = new FirstClass(1, 4.9, 2 as Short)
        firstClass.printSmth()
        Binding first = new Binding()
        first.setVariable("firstClassint", firstClass.intA = 10)
        first.setVariable("firstClassdouble", firstClass.doubB = 10.87)
        first.setVariable("firstClassshort", firstClass.shC = 5)
        firstClass.printSmth()
        String s = new String("hello")
        System.out.println(s instanceof Integer)
        def c
        c = "name"
        println c
        c = 5
        println c
        def b = 4
        println b
        b = "bye"
        println b
        println firstClass.retInteger(null)
//        println firstClass.retInt(null)

        def b1 = new BigDecimal(15.0)
        def b2 = new BigDecimal(15.0)
        println b1.getMetaClass()
        println b2.getMetaClass()
        println b1.equals(b2)
        println b1.add(b2)
        println b1.divide(b2)
        println b1.multiply(b2)
        println b1 + b2
        println b1 / b2
        println b1 * b2


        Date date1 = new Date(2015, 1, 28)
        Date date2 = new Date(2015, 0, 31)
        use(groovy.time.TimeCategory) {
            println date1 - date2
            date1 = date1 - 1.month
            println date1
            date1 = date1 + 1.month
            println date1
            date1 = date1 + 1.day
            println date1
        }

        def operation1 = { AA, BB ->
            AA / BB
        }
        def operation2 = { DD, CC ->
            DD - CC
        }
        def operation3 = { AA, BB, CC ->
            operation2(operation1(AA, BB), CC)
        }
        println operation1(8, 4)
        println operation2(7, 3)
        println operation3(8, 4, 2)
    }
}
