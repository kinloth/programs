module BookKeeping
  VERSION = 1 # Where the version number matches the one in the test.
end

class Grains
  def self.square(num)
    # invalid argument! chessboard have 64 squares
    raise ArgumentError if num < 1 || num > 64
    2 ** (num-1)
  end

  # the sum of all base 2 expoent will be allways the double of value - 1
  def self.total
    self.square(64) * 2 - 1
  end

end