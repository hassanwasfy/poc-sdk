Pod::Spec.new do |s|
  s.name         = "POC"
  s.version      = "0.1.0"
  s.summary      = "POC SDK"
  s.homepage     = "https://hassanwasfy.github.io/"
  s.license      = "MIT"
  s.author       = { "Hassan" => "hassan.wasfy@edfapay.com" }
  s.source       = { :git => "https://github.com/hassanwasfy/poc-sdk.git", :tag => s.version.to_s }
  s.ios.deployment_target = "16.0"
  s.vendored_frameworks = "composeApp/build/POC.xcframework"
  s.static_framework       = true
end
