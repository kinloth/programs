module BookKeeping
	VERSION = 5 # Where the version number matches the one in the test.
end

class Gigasecond
	GIGA_SECOND = 10 ** 9 # gigasecond constant

	def self.from date	
		date + GIGA_SECOND
	end
end