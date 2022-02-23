package chapter18

object Simulator extends App {
  object MySimulation extends CircuitSimulation {
    def InverterDelay: Int = 1
    def AndGateDelay = 3
    def OrGateDelay = 5
  }

  val input1, input2, sum, carry = new MySimulation.Wire
  MySimulation.probe("sum", sum)
  MySimulation.probe("carry", carry)
  MySimulation.halfAdder(input1, input2, sum, carry)
  input1.setSignal(true)
  MySimulation.run()

}
