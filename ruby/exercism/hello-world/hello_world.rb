class HelloWorld
	def self.hello name = nil
		name ? "Hello, #{name}!" : "Hello, World!"
    end
end