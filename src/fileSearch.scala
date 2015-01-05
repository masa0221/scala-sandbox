import java.io.File
import scala.annotation.tailrec
import scala.io.Source

// def find(keyword: String, root: java.io.File): Seq[java.io.File]
object fileSearch extends App {


  println(find("normal", new File("/Users/cw_tsuru/stocklicense")))
  println(search("cmttkwkw", new File("/Users/cw_tsuru/stocklicense")))
  // println(search("JCDV", new File("/Users/cw_tsuru/stocklicense")))

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
    @tailrec
    def getFiles(root_files: Seq[java.io.File], files: Seq[java.io.File], directories: Seq[java.io.File]): Seq[java.io.File] = {
      val current_files = root_files.filter {
        _.isFile
      }.toSeq

      val current_directories = root_files.filter {
        _.isDirectory
      }.toSeq

      val all_files = current_files ++ files
      val all_directories =  current_directories ++ directories

      if (all_directories.isEmpty) return all_files

      getFiles(all_directories.head.listFiles(), all_files, all_directories.tail)
    }

    val files: Seq[File] = getFiles(root.listFiles(), Seq(), Seq())
    files.filter {
      f =>
        Source.fromFile(f).getLines().exists(_.contains(keyword))
    }
    // Seq().ex
    // (for (f <- getFiles(root.listFiles(), Seq(), Seq())) yield {
    //   Source.fromFile(f).getLines().toSeq.map {
    //     case l if l.contains(keyword) => f
    //   }
    // }.distinct).flatten
  }
}
