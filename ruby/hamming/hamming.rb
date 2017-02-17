module BookKeeping
	VERSION = 3 # Where the version number matches the one in the test.
end

class Hamming
	def self.compute (dna1, dna2)
		# if input are not equals in lenght
		if dna1.length != dna2.length
			raise ArgumentError
		end

		# rapid verification if are equals
		if dna1 == dna2 
			return 0
		end

		# calc the hamming distance
		distance = 0
		dna1.split("").each_index do |i|
			if dna1[i] != dna2[i]
				distance += 1
			end
		end

		# return the hamming distnace
		distance
	end
end

