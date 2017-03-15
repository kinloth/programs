module BookKeeping
  VERSION = 3 # Where the version number matches the one in the test.
end

class Raindrops
  def self.convert number
    converted = ''
    factors = []
    i = 1

    # find the factors
    number.times do
      if number % i == 0
        factors << i 
      end
      i += 1
    end
    
    # translate
    converted << "Pling" if factors.include? 3
    converted << "Plang" if factors.include? 5
    converted << "Plong" if factors.include? 7 
    
    # check if have something, else received to last of factors
    converted << factors[-1].to_s if converted == ''

    # return the raindrop-speak
    converted  
  end
end