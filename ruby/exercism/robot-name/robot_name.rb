module BookKeeping
	VERSION = 2
end

class Robot
  attr_accessor :name
  @@names = []
  def initialize
    @name = generate
    while @@names.include? self.name
      @name = generate
    end
    @@names << self.name
  end

  def reset
    self.name = generate
  end

  def generate
    string_generate(2) + number_generate(3)
  end

  def string_generate(num)
    string = ''
    num.times do
      string << ('A'..'Z').to_a.sample
    end
    string
  end

  def number_generate(num)
    number = ''
    num.times do
      number << ('1'..'9').to_a.sample
    end
    number
  end

end

