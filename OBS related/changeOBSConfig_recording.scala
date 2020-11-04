import java.io.File
import java.io.BufferedWriter
import java.io.FileWriter

/* V1.0
||||||||||||||||||||||||||||||||||||||||||||||||||||||||
|                 ___________________                  |                                 
|          \_/--  | HIRUSHA ADIKARI |  --\_/           |                    
|                                                      |           
|                                                      |         
|                                                      |
| When sharing, mention that this is made by           |                                           
| Hirusha Adikari for the effort done and giving       |                                              
| this for free!!                             	       |
|                                                      |
|           - Like, Subscribe, Share for more content  |                                         
|           - Hirusha Adikari - YT, IG, Twitter        |                      
|||||||||||||||||||||||||||||||||||||||||||||||||||||||| */

object Main extends App {

  // main ini file of OBS
  val filePath = "C:/Users/hirusha/AppData/Roaming/obs-studio/global.ini"
  val iniFile = new File(filePath)

  println(s"Found ini file: ${iniFile.exists()}")

  // strings to change
  val contentRecording = "SceneCollection=1 Recording\nSceneCollectionFile=1_Recording\nProfile=1.1 Recording StSt\nProfileDir=11_Recording_StSt"
  val contentStreaming = "SceneCollection=2 Streaming\nSceneCollectionFile=2_Streaming\nProfile=2 Streaming\nProfileDir=2_Streaming"

  // current configuration
  val fileContent = scala.io.Source.fromFile(iniFile).getLines.mkString("\n")
  val foundRecording = fileContent.contains(contentRecording)
  val foundStreaming = fileContent.contains(contentStreaming)

  println(s"Found recording: $foundRecording")
  println(s"Found streaming: $foundStreaming")

  // change content
  var updatedFileContent = fileContent
  if (foundStreaming) {
    updatedFileContent = fileContent.replace(contentStreaming, contentRecording)
    println("Replaced streaming settings with recording settings.")
  } else {
    println("Did nothing.")
  }

  // save
  val writer = nesw BufferedWriter(new FileWriter(iniFile))
  writer.write(updatedFileContent)
  writer.close()

  println("Updated file.")
}