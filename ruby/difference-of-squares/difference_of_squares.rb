module BookKeeping
  VERSION = 3 # Where the version number matches the one in the test.
end

class Squares
  def initialize number
    @number = number
  end

  # calc the square of sum for @number first numbers
  # ex. (1 + 2 + ... + 10)**2 = 55**2 = 3025 , for @number = 10
  def square_of_sum
    (1..@number).inject(0, &:+) ** 2      
  end

  # calc the sum of squares for @number first numbers
  # ex. 1**2 + 2**2 + ... + 10**2 = 385 , for @number = 10
  def sum_of_squares
    (1..@number).inject(0) do |sum , number|
      sum + number ** 2
    end
  end

  # calc the difference between sums above
  def difference
    self.square_of_sum - self.sum_of_squares
  end
end