function convertToSpeech(){
    var text=document.getElementById("text").value;
    var textToSpeechUrl='https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?username=526eb7fa-593f-4dd8-bd04-9891b29f0cd2&password=taCKo3m6t7zc&text='+text;


    document.getElementById("playAudio").innerHTML= "<video controls='' autoplay='' name='media'> <source src='"+textToSpeechUrl+"' type='audio/ogg'> </video>";
}