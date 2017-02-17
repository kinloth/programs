module BookKeeping
    VERSION = 1 # Where the version number matches the one in the test.
end

class Prime
  @primes = [2]

  def self.nth(n)
    raise ArgumentError if n <= 0
    number = 3

    while @primes.size < n do
      @primes.push(number) if self.is_prime?(number)
      number += 2
    end
    @primes[n-1]
  end

  def self.is_prime?(number)
    @primes.each do |prime|
      return false if number % prime == 0
    end
    true
  end

end