Pod::Spec.new do |s|
  s.name         = "POC"
  s.version      = "0.2.0"
  s.summary      = "POC SDK"
  s.homepage     = "https://hassanwasfy.github.io/"
  s.license      = "MIT"
  s.author       = { "Hassan" => "hassan.wasfy@edfapay.com" }
  s.ios.deployment_target = "16.0"
  s.source = { :http => "https://github.com/hassanwasfy/poc-sdk/releases/download/0.2.0/POC.zip" }
  s.vendored_frameworks = "POC.xcframework"
  s.static_framework       = true
end
