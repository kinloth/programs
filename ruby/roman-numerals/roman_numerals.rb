module BookKeeping
	VERSION = 2
end

class Integer
  def to_roman
    romans = ["I","V", "X", "L", "C", "D", "M"]
    pivot1 = 0
    pivot2 = 1
    numbers = self.to_s.split('').map(&:to_i)
    result = ""
    temp = ""

    digits = self.to_s.length
    numbers.reverse_each do |digit|
      rest = digit % 5
      quoc = digit / 5

      # case 1: digit == 9
      if quoc == 1 and rest == 4
        temp  << romans[pivot1] << romans[pivot1+2]
      # case 2: digit == 4
      elsif quoc == 0 and rest == 4
        temp << romans[pivot1] << romans[pivot2]
      else
        temp << romans[pivot2] if quoc == 1
        
        rest.times do |unit|
          temp << romans[pivot1] 
        end
      end

      pivot1 += 2
      pivot2 += 2
      result = temp.concat(result)
      temp = ""
    end
    result
  end

end
