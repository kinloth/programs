module BookKeeping
  VERSION = 2 # Where the version number matches the one in the test.
end

class Year
  def self.leap? (year)
    if year % 4 == 0
      leap = true
      if year % 100 == 0 and not year % 400 == 0
        leap = false
      end
    end
    leap
  end
end