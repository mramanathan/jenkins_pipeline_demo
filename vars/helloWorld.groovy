def call(name) {
   node('linux') {
       stage(' =~ Shared Lib =~ ') {
           echo "Hello ${name}, Welcome to the world of conundrums!!!"
       }
   }
}
