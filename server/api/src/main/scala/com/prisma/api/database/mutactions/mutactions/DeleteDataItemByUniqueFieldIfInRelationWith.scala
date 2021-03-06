package com.prisma.api.database.mutactions.mutactions

import com.prisma.api.database.DatabaseMutationBuilder
import com.prisma.api.database.mutactions.{ClientSqlDataChangeMutaction, ClientSqlStatementResult}
import com.prisma.api.mutations.{NodeSelector, ParentInfo}
import com.prisma.shared.models.Project

import scala.concurrent.Future

case class DeleteDataItemByUniqueFieldIfInRelationWith(
    project: Project,
    parentInfo: ParentInfo,
    where: NodeSelector
) extends ClientSqlDataChangeMutaction {

  override def execute: Future[ClientSqlStatementResult[Any]] = Future.successful(
    ClientSqlStatementResult(DatabaseMutationBuilder.deleteDataItemByUnique(project.id, where))
  )
}
