module BookKeeping
	VERSION = 1
end

class Sieve
  def initialize number
    @number = number
  end

  def primes
    primes = []
    return primes if @number < 2

    # definitions
    control = Array.new(@number - 1,0)
    range = (2..@number).to_a

    # Sieve algorithm main loop
    range.each_with_index do |current, index|

      # if number is not-prime marked then next, else add in primes values
      control[index] == 1 ? next : primes << current

      # comparition loop, verify with next values if are divisible with current
      (current..@number).each do |aux_value|

        # conditions for jump iteration
        next if current > @number or current == aux_value      

        # if are divisible then mark in control
        if aux_value % current == 0
          control[range.index(aux_value)] = 1
        end
      end
    end
    primes
  end
end