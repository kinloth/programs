module BookKeeping
  VERSION = 1 # Where the version number matches the one in the test.
end

class Phrase
  attr_accessor :phrase
  def initialize(phrase)
    self.phrase = phrase.downcase
    self.phrase.gsub!(/[^a-zA-Z0-9']/, ' ')
    self.phrase.gsub!(/(' )|( ')/, ' ')
  end

  def word_count
    counts = Hash.new 0
    words =  self.phrase.split(' ')
    words.each do |word|
      counts[word] += 1
    end
    counts
  end
end