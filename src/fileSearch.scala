import java.io.File
import scala.annotation.tailrec
import scala.io.Source

// def find(keyword: String, root: java.io.File): Seq[java.io.File]
object fileSearch extends App {


  println(find("html", new File("/Users/cw_tsuru/Source/document/")))
  println(search("lint", new File("/Users/cw_tsuru/Source/document/")))

  def find(keyword: String, root: java.io.File): Seq[java.io.File] = {
    @tailrec
    def getFiles(keyword: String, root_files: Seq[java.io.File], files: Seq[java.io.File], directories: Seq[java.io.File]): Seq[java.io.File] = {
      val current_files = root_files.filter {
        _.isFile
      }.filter {
        _.getName.contains(keyword)
      }.toSeq

      val current_directories = root_files.filter {
        _.isDirectory
      }.toSeq

      val all_files = current_files ++ files
      val all_directories =  current_directories ++ directories

      if (all_directories.isEmpty) return all_files

      getFiles(keyword, all_directories.head.listFiles(), all_files, all_directories.tail)
    }

    getFiles(keyword, root.listFiles(), Seq(), Seq())
  }

  def search(keyword: String, root: java.io.File): Seq[java.io.File] = {
    // root.listFiles().foreach {
    //   file => Source.fromFile(file.getName)
    // }
    // root.listFiles().filter {}

    Seq(root)
  }
}
