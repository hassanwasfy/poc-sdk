Pod::Spec.new do |s|
  s.name     = "POC"
  s.version  = "0.1.0"
  s.summary  = "POC SDK for weather"
  s.homepage = "https://hassanwasfy.github.io/"
  s.license  = "MIT"
  s.author   = { "Hassan" => "hassan.wasfy@edfapay.com" }
  s.source   = { :git => "https://github.com/hwasfy/poc-sdk.git", :tag => "0.1.0" }
  s.vendored_frameworks = "build/bin/ios/*/POC.framework"
  s.ios.deployment_target = "16.0"
end
